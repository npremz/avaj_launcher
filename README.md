# Avaj Launcher - Aviation Weather Simulation

## Description

Avaj Launcher est un projet de simulation météorologique pour l'aviation développé en Java. Le programme simule le comportement de différents types d'aéronefs (avions, hélicoptères, ballons) en fonction des conditions météorologiques changeantes.

Ce projet met en œuvre plusieurs design patterns importants :
- **Singleton Pattern** : pour WeatherProvider et AircraftFactory
- **Observer Pattern** : pour la communication entre la tour de contrôle et les aéronefs
- **Factory Pattern** : pour la création des différents types d'aéronefs

## Architecture du Projet

Le projet est organisé selon une architecture en couches :

```
be.npremont.avaj/
├── models/              # Modèles de données et entités
│   ├── Aircraft.java
│   ├── Baloon.java
│   ├── Coordinates.java
│   ├── Helicopter.java
│   ├── JetPlane.java
│   ├── Tower.java
│   └── WeatherTower.java
├── interfaces/          # Interfaces du projet
│   └── Flyable.java
├── services/            # Services et logique métier
│   ├── AircraftFactory.java
│   ├── SimulationService.java
│   └── WeatherProvider.java
├── exceptions/          # Exceptions personnalisées
│   ├── InvalidCoordinatesException.java
│   ├── InvalidFormatException.java
│   └── InvalidScenarioException.java
└── Simulator.java       # Point d'entrée principal
```

## Compilation et Exécution

### Compilation

Le projet inclut un script de compilation automatique :

```bash
bash compile.sh
```

Ce script compile tous les fichiers `.java` du projet.

### Exécution

Une fois compilé, lance la simulation avec un fichier de scénario :

```bash
java be.npremont.avaj.Simulator scenario.txt
```

## Format du Fichier de Scénario

Le fichier de scénario doit suivre ce format :

```
<nombre_de_simulations>
<TYPE> <NOM> <LONGITUDE> <LATITUDE> <HEIGHT>
<TYPE> <NOM> <LONGITUDE> <LATITUDE> <HEIGHT>
...
```

### Exemple de fichier `scenario.txt` :

```
25
Baloon B1 2 3 20
Baloon B2 1 8 66
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
```

### Contraintes :

- **Nombre de simulations** : doit être un entier positif
- **TYPE** : doit être `Baloon`, `JetPlane` ou `Helicopter`
- **NOM** : nom de l'aéronef (chaîne de caractères)
- **LONGITUDE** : coordonnée >= 0
- **LATITUDE** : coordonnée >= 0
- **HEIGHT** : altitude entre 0 et 100

## Conditions Météorologiques

Le simulateur génère quatre types de météo :
- **SUN** (Soleil)
- **RAIN** (Pluie)
- **FOG** (Brouillard)
- **SNOW** (Neige)

Chaque type d'aéronef réagit différemment selon les conditions :

### JetPlane (Avion de ligne)
- **SUN** : +10 latitude, +2 hauteur
- **RAIN** : +5 latitude
- **FOG** : +1 latitude
- **SNOW** : -7 hauteur

### Helicopter (Hélicoptère)
- **SUN** : +10 longitude, +2 hauteur
- **RAIN** : +5 longitude
- **FOG** : +1 longitude
- **SNOW** : -12 hauteur

### Baloon (Montgolfière)
- **SUN** : +2 longitude, +4 hauteur
- **RAIN** : -5 hauteur
- **FOG** : -3 hauteur
- **SNOW** : -15 hauteur

## Fonctionnalités

**Enregistrement et désenregistrement** : Les aéronefs s'enregistrent auprès de la tour de contrôle au démarrage et se désenregistrent automatiquement lorsqu'ils atterrissent (hauteur = 0).

**Mise à jour des conditions** : À chaque itération de la simulation, la météo change et tous les aéronefs en vol ajustent leur position en conséquence.

**Atterrissage automatique** : Lorsqu'un aéronef atteint une hauteur de 0, il atterrit et se retire de la simulation.

**Messages contextuels** : Chaque aéronef affiche des messages spécifiques selon les conditions météorologiques rencontrées.

## Gestion des Erreurs

Le programme gère plusieurs types d'erreurs :

- **InvalidCoordinatesException** : coordonnées invalides (négatives ou hauteur > 100)
- **InvalidFormatException** : format de ligne incorrect dans le fichier de scénario
- **InvalidScenarioException** : fichier vide ou nombre d'itérations invalide
- **IllegalArgumentException** : type d'aéronef inconnu
- **IOException** : problèmes de lecture du fichier

## Exemple de Sortie

```
Tower says: Baloon#B1(0) registered to weather tower.
Tower says: JetPlane#J1(1) registered to weather tower.
Baloon#B1(0): Let's enjoy the good weather and take some pics.
JetPlane#J1(1): It's raining. Better watch out for lightings.
...
Baloon#B1(0) landing.
Tower says: Baloon#B1(0) unregistered to weather tower.
```

## Concepts Techniques Utilisés

**Design Patterns** :
- Singleton (WeatherProvider, AircraftFactory)
- Observer (Tower/Flyable)
- Factory (AircraftFactory)

**POO** :
- Héritage (Aircraft → JetPlane, Helicopter, Baloon)
- Polymorphisme (interface Flyable)
- Encapsulation (attributs privés/protégés)

**Gestion des exceptions** : Exceptions personnalisées pour une meilleure gestion des erreurs

**Collections Java** : Utilisation d'ArrayList pour gérer les observateurs

## 📄 Licence

Ce projet est réalisé dans le cadre du cursus de l'École 42.
