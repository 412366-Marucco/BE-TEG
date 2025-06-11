## Interfaz "Achievable"
Su contrato indica que cualquier clase que lo implemente debe ser completable. La implementarán las clases Objective, CountryTask y PlayerTask.
### Métodos
- `isAchieved(Player player) : boolean`

## Interfaz "Perfil"
Define las acciones que debe realizar un bot según su dificultad, indicando cómo juega en las fases de ataque, reagrupamiento y canje.
### Métodos

- `calculateAttackPhase() : void `
- `calculateRegroupPhase() : void`
- `calculateExchangePhase() : void`
