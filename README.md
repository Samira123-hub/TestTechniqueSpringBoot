# 📊 Gestionnaire de Projets et de Tâches

Une application web développée avec **Spring Boot** et **Thymeleaf** pour gérer des projets, leurs échéances, et les tâches associées.

## 🚀 Fonctionnalités

- 🔹 Création, modification et suppression de projets
- 🔹 Association de tâches à un projet
- 🔹 Formulaire dynamique pour ajouter et modifier une tâche
- 🔹 Affichage des tâches par projet
- 🔹 Intégration front-end avec **Thymeleaf** et **HTML/CSS**
- 🔹 Accès à la console H2 (`/h2-console`) pour test en mémoire

## 🛠️ Technologies

- **Java 17+**
- **Spring Boot 3**
- **Thymeleaf**
- **Spring MVC / Data JPA**
- **H2 Database (mode mémoire)**
- **Postman** pour les tests API REST
- **Git** & **GitHub** pour le versionnage

## 📦 Structure du projet

```shell
src/
├── main/
│   ├── java/com/example/TestTechniqueBack/
│   │   ├── controllers/
│   │   ├── entities/
│   │   ├── services/
│   │   ├── repositories/
│   │   └── config/
│   └── resources/
│       ├── templates/
│       ├── static/css/
│       └── application.properties
