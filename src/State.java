/* Authors: Frejoux Gaetan & Niord Mathieu */

/* ------------------------------------------------------
| This class corresponds to the state of a vertex        |
| during a course of a graph. There are three            |
| different states: - Green: Not yet visited;            |
|                   - Orange: Visited but not processed; |
|                   - Red: Visited and fully processed.  |
 -------------------------------------------------------- */

public enum State {
    GREEN,
    ORANGE,
    RED
}
