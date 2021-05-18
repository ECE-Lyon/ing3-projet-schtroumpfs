# schtroumpfs

Le projet se decoupe en trois parties : modeles, view et controleur. Il y a egalement la partie base de données à part.

MODELE:
Dans cette partie nous avons définie les différentes classes qui représentes les types d'utilisateurs ou d'objet à manipuler.

Il y a les films et seances qui sont utilisées pour manipuler les ressources récupérées depuis les bases de données.

Il y a egalement les differents types d'utilisateur : employé, client, client membre (avec un compte) et client non connecte. 
Ces classes ne sont pas utiliser pour le moment dans le code mais sont crées (pour la plupart) et donc peuvent être implémentées.


CONTROLEUR:
Cette partie correspond aux différentes fonctions utilisées à travers le programme, ces méthodes permettent de récupérer ou d'ajouter des données dans les bases de données

La classe accueil regroupe les méthodes de connection (qui vérifient si le pseudo entré correspond au mot de passe), il y a également une méthode qui récupère la fidélité.

La classe recherche regroupe les méthodes de récupération de film (image ou information) dans la bdd.

La classe seance contient la methode recuperant l'ensemble des seances d'un film.


VIEW:
Cette partie permet l'affichage dans différentes pages.

FrameSign est la page d'accueil avec différentes parties pour se connecter ou non en tant que client, se créer un compte ou bien se connecter en tant qu'employé.

FrameStaff atteint après une connection d'employé contient des espaces pour ajouter un film dans la base de donnée. 
(il manque la méthode ajoutant le film dans la base de données mais les champs sont prêts pour l'ajout)

FrameFilm est la page utilisée par les clients pour choisir le film à voir, il y a un affichage de toutes les jaquettes et un bouton correspondant pour atteindre la page des séances.

FramePay est la page des séances qui récapitule les informations du film sélectionné, propose des films similaires pour le client et affiche toutes les séances. Un espace pour entrer le nombre de places désiré et un bouton de validation sont au pied de la page.


BASE DE DONNEES:
Dans cette base il y a 4 tables:

Une table pour les clients avec leurs pseudos et mot de passe, ainsi que la fidelite associee.
Une table de films avec toutes les informations correspondantes.
Une table de seances liée à la table de films.
Une table pour le staff similaire à celle des clients.
