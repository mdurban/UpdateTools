import spock.lang.Specification
import spock.lang.Unroll

class BoundedIntegerSpec extends Specification {

    def "integer within specified range should return that integer"() {
        setup:
            BoundedInteger boundedInt = new BoundedInteger(0, 100)
            boundedInt.setValue 1

        expect:
            boundedInt.getValue() == 1
    }
    
    @Unroll
    def "range should be inclusive on both ends"() {
        setup:
            BoundedInteger boundedInt = new BoundedInteger(0, 100)
            boundedInt.setValue x

        expect:
            boundedInt.getValue() == y

        where:
        x  |  y
        0  |  0
        100|  100
    }

    def "if value is more than max, value should use max"() {
        setup:
            BoundedInteger boundedInt = new BoundedInteger(0, 100)
            boundedInt.setValue 101

        expect:
            boundedInt.getValue() == 100
    }
    
    def "if value is less than min, value should use min"() {
        setup:
            BoundedInteger boundedInt = new BoundedInteger(10, 100)
            boundedInt.setValue 9

        expect:
            boundedInt.getValue() == 10
    }
}
