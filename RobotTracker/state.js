class State {
    constructor () {

    }

    next(r, f) {
        this.action();
        if (r == 0 && f == 0) {
            return this._00_();
        }
    }
}