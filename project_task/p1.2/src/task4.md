**Call Centre Simulation: Clock 16 (Event B4, B3)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | Empty        | Idle   | X3           | Idle   | Empty        | Y1     |
| C     | Empty        | Idle   | Empty        | X3     | Empty        | Y1     |

Event List:

| Event | Time |
|-------|------|
| B5    | 18   |
| B2    | 20   |
| B1    | 20   |
| B4    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 2 |
| Y                | 0 |

**Call Centre Simulation: Clock 15 (Event B5)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | Empty        | Idle   | Empty        | X3     | Empty        | Idle   |
| C     | Empty        | Idle   | Empty        | X3     | Empty        | Idle   |

Event List:

| Event | Time |
|-------|------|
| B2    | 20   |
| B1    | 20   |
| B4    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 2 |
| Y                | 1 |