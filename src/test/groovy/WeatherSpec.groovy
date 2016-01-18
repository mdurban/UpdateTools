import spock.lang.Specification
import groovy.json.*;

class WeatherSpec extends Specification {

    private static final def KELVIN_TEMP = 283.15
    Weather weather
    JsonSlurper slurper 

    def setup() {
       weather = new Weather(state: "oh", city: "columbus")
       slurper = [parseText: {
           String json -> ["main":["temp": KELVIN_TEMP]]
       }] as JsonSlurper
       weather.slurper = slurper
    }

    def "getCurrentTemperature should return current temperature of city"() {
        expect:
            weather.getCurrentTemperature() == 50.0
    }
}
