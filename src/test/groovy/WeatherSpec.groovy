import spock.lang.Specification
import groovy.json.*;

class WeatherSpec extends Specification {

    private static final def KELVIN_TEMP = 283.15
    Weather weather

    def setup() {
       weather = new Weather(state: "oh", city: "columbus")
    }

    def "getCurrentTemperature should return current temperature of city"() {
        setup:
           def slurper = [parseText: {
               String json -> ["main":["temp": KELVIN_TEMP]]
           }] as JsonSlurper
           weather.slurper = slurper
           
        expect:
            weather.getCurrentTemperature() == 50.0
    }

    def "getCurrentConditions should return current weather conditions of city"() {
        setup:
           def slurper = [parseText: {
               String json -> ["weather":["description": "sky is clear"]]
           }] as JsonSlurper
           weather.slurper = slurper
           
        expect:
            weather.getCurrentConditions() == "sky is clear"
    }
}
