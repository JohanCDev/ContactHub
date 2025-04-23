#!/bin/zsh

cd ./server/

# Lancer la compilation continue de Kotlin en arrière-plan et rediriger les logs
echo "Démarrage de la compilation continue de Kotlin..."
./gradlew compileKotlin --continuous --parallel --build-cache --configuration-cache &

# Lancer Spring Boot et rediriger les logs
echo "Démarrage de l'application Spring Boot..."
./gradlew bootRun