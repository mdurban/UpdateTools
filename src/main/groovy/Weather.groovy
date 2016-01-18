import groovy.json.*;

class Weather {
    
    private static final OPEN_WEATHER_MAP_EXAMPLE_APPID = '2de143494c0b295cca9337e1e96b00e0'
    private String state
    private String city
    private JsonSlurper slurper = new JsonSlurper()

    def getCurrentTemperature() {
        String jsonOutput = getWeatherData('weather', '${city},${state}')
        convertToFahrenheit slurper.parseText(jsonOutput).main.temp
    }
    
    def getCurrentConditions() {
         String jsonOutput = getWeatherData('weather', '${city},${state}')
         slurper.parseText(jsonOutput).weather.description
    }

    def convertToFahrenheit(kelvinTemp) {
        (kelvinTemp - 273.15) * 1.80 + 32.00
    }

    def getWeatherData(String key, String value) {
        String jsonOutput = "http://api.openweathermap.org/data/2.5/${key}?q=${value}&appid=${OPEN_WEATHER_MAP_EXAMPLE_APPID}".toURL().text
    }

}
