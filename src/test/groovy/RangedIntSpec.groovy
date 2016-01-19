import spock.lang.Specification
import spock.lang.Unroll

class RangedIntSpec extends Specification {

    def "integer within specified range should return that integer"() {
        setup:
            RangedInt rangedInt = new RangedInt(0, 100)
            rangedInt.setValue 1

        expect:
            rangedInt.getValue() == 1
    }
    
    @Unroll
    def "range should be inclusive on both ends"() {
        setup:
            RangedInt rangedInt = new RangedInt(0, 100)
            rangedInt.setValue x

        expect:
            rangedInt.getValue() == y

        where:
        x  |  y
        0  |  0
        100|  100
    }

    def "if value is more than max, value should use max"() {
        setup:
            RangedInt rangedInt = new RangedInt(0, 100)
            rangedInt.setValue 101

        expect:
            rangedInt.getValue() == 100
    }
    
    def "if value is less than min, value should use min"() {
        setup:
            RangedInt rangedInt = new RangedInt(10, 100)
            rangedInt.setValue 9

        expect:
            rangedInt.getValue() == 10
    }
}
