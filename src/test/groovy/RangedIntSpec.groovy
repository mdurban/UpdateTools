import spock.lang.Specification

class RangedIntSpec extends Specification {

    def "integer within specified range should return that integer"() {
        setup:
            RangedInt rangedInt = new RangedInt(0, 100)
            rangedInt.setValue 1

        expect:
            rangedInt.getValue() == 1
    }
    
    def "range should be inclusive for min"() {
        setup:
            RangedInt rangedInt = new RangedInt(0, 100)
            rangedInt.setValue 0

        expect:
            rangedInt.getValue() == 0
    }

    def "range should be inclusive for max"() {
        setup:
            RangedInt rangedInt = new RangedInt(0, 100)
            rangedInt.setValue 100

        expect:
            rangedInt.getValue() == 100
    }
    
    def "if value is more than max, value should use max"() {
        setup:
            RangedInt rangedInt = new RangedInt(0, 100)
            rangedInt.setValue 101

        expect:
            rangedInt.getValue() == 100
    }
}
