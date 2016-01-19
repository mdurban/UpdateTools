import spock.lang.Specification
import groovy.json.*;

class WeatherSpec extends Specification {

    private static final def KELVIN_TEMP = 283.15

    def "getCurrentTemperature should return current temperature of city"() {
        setup:
           def slurper = [parseText: {
               String json -> ["main":["temp": KELVIN_TEMP]]
           }] as JsonSlurper
           Weather.slurper = slurper
           
        expect:
           Weather.getCurrentTemperature("columbus", "oh") == 50.0
    }

    def "getCurrentConditions should return current weather conditions of city"() {
        setup:
           def slurper = [parseText: {
               String json -> ["weather":["description": "sky is clear"]]
           }] as JsonSlurper
           Weather.slurper = slurper
           
        expect:
           Weather.getCurrentConditions("columbus", "oh") == "sky is clear"
    }

    def "getFiveDayForecast should return temperatures of next five days of city"() {
        setup:
           def slurper = [parseText: {
               String json -> ["list":[["temp":["day":10.0]], ["temp":["day":20.0]], ["temp":["day":30.0]], ["temp":["day":40.0]], ["temp":["day":50.0]], ["temp":["day":60.0]], ["temp":["day":70.0]]]]
           }] as JsonSlurper
           Weather.slurper = slurper
           
        expect:
           Weather.getFiveDayForecast("columbus", "oh") == [10.0, 20.0, 30.0, 40.0, 50.0]
    }

}
