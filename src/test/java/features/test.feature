Feature: acheter votre voiture

  Scenario: lancer la recherche sur google
    Given lancer la page de recherche
    When saisir l'objet de recherche
    And choisir la marque de voiture
    And choisir le modele de voiture
    Then nous sommes sur la page sible


