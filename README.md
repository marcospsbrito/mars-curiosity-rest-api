# mars-curiosity-rest-api

The Mars Curiosity Restful API, simulate a entry point to move the Curiosity robot and explore the Mars terrain. 


## Curiosity Specification

### Endpoints 
 - http://<host>:8080/rest/mars
 - http://<host>:8080/rest/mars/{Movements: [M|R|L]*}
 
### Movements

- **L:** Left Rotation
- **R:** Right Rotation
- **M:** Move ahead

### Response Object

**({X position}, {Y position}, {Direction})**


### Direction

- **S:** South
- **N:** North
- **W:** Weast
- **E:** East

### Rules
- Curiosity can't move out a piece (5x5) of Mars Terrain.
- Curiosity can't ever start from the point [0:0] with North(N) direction.
- Curiosity return to start point after the end of command (because it is stateless).
