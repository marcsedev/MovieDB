# MovieDB

## Preguntas de interés

#### 1. ¿En qué consiste el método de responsabilidad única? ¿Cuál es su propósito?

Es el principio S de SOLID, el cual dice que una clase debe encargarse de una sola acción. Por ejemplo el Repository se encarga de manejar los datos.No deberia encargarse de hacer el Mapeo de Objetos DTO a Domain. Para eso se crea una clase o extension Mapper.

#### 2. ¿Què deberia tener un código limpio?

- Debería tener test. Sin él es muy dicícil refactorizar en un futuro.
- Respetar, en lo medida d elo posible, los principios SOLID.


