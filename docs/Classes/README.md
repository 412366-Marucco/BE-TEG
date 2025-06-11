# Trabajo Práctico Integrador - TEG - Grupo 5

A continuación, describimos la estructura de clases propuesta para la resolución del Trabajo Práctico Integrador.

## Game
### Responsabilidades
Gestionar la creación de partidas nuevas y el guardado y cargado de partidas. 
### Atributos
- `List<Match> matches`
### Métodos
- `getMatches() : Match`
- `saveMatch() : Boolean`
- `loadMatch() : Boolean`
- `newMatch() : Boolean`

## Match
### Responsabilidades
Gestionar el bucle básico de la partida, controlar condiciones de victoria, inicializar cantidad de jugadores humanos y bots, asignar países y objetivos a los jugadores y asignar orden de juego.
### Atributos
- `Integer id`
- `Stack<Player> players`
- `Board board`
- `Logger logger`
- `MatchState state`
- `Player winner`
### Métodos
- `start()`
- `end()`
- `pause()`
- `resume()`
- `hasEnded() : Boolean`


## Logger
### Responsabilidades
Mantener un registro de los eventos realizados en cada partida. Añadir eventos y recuperar registro.
### Atributos
- `Stack<Action> actions`
### Métodos
- `getLog() : Stack<Action>`
- `addAction()`


## Action
### Responsabilidades
Registrar información sobre una acción de juego, como países y jugadores involucrados, turno y fase en el que ocurrió y tipo de acción.  
### Atributos
- `Integer turn`
- `TurnPhase phase`
- `ActionType type`
- `Set<Player> players`
- `Set<Country> countries` 
### Métodos
- `toString() : String`


## Player
### Responsabilidades
Gestionar las decisiones que puede tomar el jugador en una partida, como atacar a un país, reagrupar sus tropas, realizar un canje y añadir tropas en países bajo su control.
### Atributos
- `Integer id`
- `String name`
- `List<Objective> objectives`
- `Player defeatedBy`
- `Color color`
### Métodos
- `attack(Country attacker, Country defensor)`
- `regroupArmy(Country origin, Country target, Intger amount)`
- `addTroops(Country target)`
- `requestCard()`
- `exchangeCard()`
- `pass()`

## BotNewbie (extends Player, implements BotProfile)
### Responsabilidades
Gestionar las acciones del bot con perfil de novato
### Atributos
- `BotProfile profile`
### Métodos

## BotBalanced (extends Player, implements BotProfile)
### Responsabilidades
Gestionar las acciones del bot con perfil balanceado
### Atributos
- `BotProfile profile`
### Métodos

## BotExpert (extends Player, implements BotProfile)
### Responsabilidades
Gestionar las acciones del bot con perfil de experto
### Atributos
- `BotProfile profile`
### Métodos

## HumanPlayer (extends Player)
### Responsabilidades
Gestionar acciones únicas de los jugadores humanos, tales como votar para reanudar, pausar o terminar la partida y retirarse de ella,
### Atributos
### Métodos
- `votePause(Boolean vote)`
- `voteResume(Boolean vote)`
- `voteEnd(Boolean vote)`
- `leaveMatch()`


## Objective implements Achievable
### Responsabilidades
Representa los objetivos de victoria de la partida.
### Atributos
- `Player player`
- `List<Achievable> tasks`
### Métodos
- `toString() : String`
- `isAchieved(Player player) : boolean`
## CountryTask implements Achievable
### Responsabilidades
Representa las tareas de conquistar paises que debe cumplir un jugador para cumplir un objetivo.
### Atributos
- `List<Country> targetCountries`
- `int ammount`
### Métodos
- `toString() : String`
- `isAchieved(Player player) : boolean`
- 
## PlayerTask implements Achievable
### Responsabilidades
Representa las tareas de destruir a un jugador que debe cumplir otro jugador para cumplir un objetivo.
### Atributos
- `Player targetPlayer`

### Métodos
- `toString() : String`
- `isAchieved(Player player) : boolean`

## Card
### Responsabilidades
Representar las cartas que los jugadores pueden obtener al conquistar un país. 
### Atributos
- `CardType type`
### Métodos


## Continent 
### Responsabilidades 
Agrupa un conjunto de países y proporciona un bonus de puntos. 
### Atributos 
- ` Integer id `
- ` String name `
- ` List<Country> countries `
- ` Integer bonus `
### Métodos 
- ` getControlBonus(player: Player): int `
- ` getCountryList: List<Country>`


## Country
### Responsabilidades
Representar un territorio del tablero junto a las tropas (fichas) que un jugador tiene asignadas a él y calcular la cantidad de dados que puede lanzar un jugador que ataque las fichas asignadas a un país. 
### Atributos
- `Integer id `
- `String name`
- `Integer troops`
- `Player owner`
- `List<Country> neighbors`
### Métodos
- `changeOwner(Player owner) Boolean`
- `addTroops(Integer amount)`
- `removeTroops(Integer amount)`
- `getAttackingDie() : Integer`
- `getDefendingDie() : Integer`



## Board
### Responsabilidades
Determinar la fase del turno de cada jugador. Gestionar los canjes de cartas por tropas que los jugadores pueden realizar: validar que el jugador tiene las cartas necesarias, calcular cantidad de tropas a otorgar según la fase del juego y determinar si el jugador puede o no solicitar una carta en su turno.

Validar si se pueden realizar reagrupaciones y ataques, validar si dos países son limítrofes, resolver solicitudes de ataque. Controlar el estado de los objetivos en juego luego de cada acción.
### Atributos
- `Random rand`
- `Graph<Country> countryLayout`
- `List<Player> playerOrder`
- `Player currentPlayer`
- `TimeOnly turnTimer`
- `TurnPhase phase`
### Métodos
- `assignCountries()`
- `assignPlayOrder()`
- `assignObjectives()`
- `initializePlayers()`
- `startSetUpPhase()`
- `startRound(Boolean isFirstRound)`
- `startReinforcementsPhase()`
- `startAttackPhase()`
- `startRegroupPhase()`
- `startExchangePhase()`
- `exchangeCards()`
- `calculateExchangeTroops() : Integer`
- `isValidCardExchange(List<Card> cards) : Boolean `
- `isValidCardRequest() : Boolean`
- `setCurrentPlayer(Player currentPlayer)`
- `resolveAttack(Country attacker, Country defender)`
- `areNeighbouring(Country c1, Country c2) : Boolean`
- `isValidAttack(Country c1, Country c2) : Boolean`
- `isValidRegroup(Country c1, Country c2) : Boolean`
- `checkVictory()`
- `checkObjective(Objective objective)`


## Enumeraciones
- CardType
- TurnPhase
- Color
- ActionType
- MatchState
- BotProfile

