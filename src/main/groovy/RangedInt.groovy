class RangedInt {

    int min
    int max
    int value

    def RangedInt(int min, int max) {
        this.min = min
        this.max = max
    }

    def setValue(int value) {
        this.value = value
    }

    int getValue() {
         value < max ? value : max
    }

}
