import groovy.json.*;

class Weather {
    
    private static final EXAMPLE_APPID = '2de143494c0b295cca9337e1e96b00e0'
    private String state
    private String city

    def slurper = new JsonSlurper()

    def getCurrentTemperature() {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=${city},${state}&appid=${EXAMPLE_APPID}"
        String jsonOutput = url.toURL().text
        JsonOutput.prettyPrint(jsonOutput)

        def temp = slurper.parseText(jsonOutput).main.temp
        convertToFahrenheit temp
    }

    def convertToFahrenheit(kelvinTemp) {
        (kelvinTemp - 273.15) * 1.80 + 32.00
    }

}
