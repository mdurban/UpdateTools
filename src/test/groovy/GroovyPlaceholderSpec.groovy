import spock.lang.Specification

class GroovyPlaceholderSpec extends Specification {

    def "checks for truthiness"() {
        given:
            def placeholder = new GroovyPlaceholder()

        expect:
            placeholder.isTruthy() == true
    }
}
