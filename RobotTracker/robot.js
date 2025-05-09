class Robot {
    constructor(x, y, direction, states) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.state = 0;
    }

    draw() {
        push();
        translate(this.x * cellSize + cellSize / 2, this.y * cellSize + cellSize / 2);
        fill("cyan");
        ellipse(0, 0, cellSize, cellSize);
        fill("black");
        rotate(-this.direction);
        ellipse(cellSize / 4, cellSize / 4, cellSize / 4, cellSize / 4);
        ellipse(cellSize / 4, -cellSize / 4, cellSize / 4, cellSize / 4);
        pop();
    }

    turnLeft() {
        this.direction += PI / 2;
        if (this.direction >= TWO_PI) {
            this.direction -= TWO_PI;
        }
    }

    turnRight() {
        this.direction -= PI / 2;
        if (this.direction < 0) {
            this.direction += TWO_PI;
        }
    }

    moveForward() {
        this.x += cos(this.direction);
        this.y -= sin(this.direction);
    }

    findWalls() {
        let x = Math.round(this.x);
        let y = Math.round(this.y);
        if (this.direction == 0) {
            return [maze[y + 1][x], maze[y][x + 1]];
        } else if (this.direction == PI / 2) {
            return [maze[y][x + 1], maze[y - 1][x]];
        } else if (this.direction == PI) {
            return [maze[y - 1][x], maze[y][x - 1]];
        } else if (this.direction == (3 * PI) / 2) {
            return [maze[y][x - 1], maze[y + 1][x]];
        }
    }

    move() {
        // inital state - move forward until wall is found
        if (this.state == 0) {
            this.moveForward();
            let walls = this.findWalls();
            if (walls[1] == 1) {
                this.state = 2;
            }
        }
        // state 1 - move forward
        else if (this.state == 1) {
            this.moveForward();
            let walls = this.findWalls();
            if (walls[0] == 1 && walls[1] == 1) {
                this.state = 2;
            } else if (walls[0] == 0) {
                this.state = 3;
            }
        }
        // state 2 - turn left until no wall in front
        else if (this.state == 2) {
            this.turnLeft();
            let walls = this.findWalls();
            if (walls[1] == 0) {
                this.state = 1;
            }
        }
        // state 3 - turn right
        else if (this.state == 3) {
            this.turnRight();
            this.state = 1;
        }
        console.log(this.state);
    }

    console() {
        push();
        stroke(0);
        textSize(32);
        fill(0);
        text("Console", cellSize * mazeSize[0] + 10, 50);
        text("State: " + this.state, cellSize * mazeSize[0] + 10, 100);
        let walls = this.findWalls();
        text("r: " + walls[0], cellSize * mazeSize[0] + 10, 150);
        text("h: " + walls[1], cellSize * mazeSize[0] + 10, 200);
        pop();
    }
}
