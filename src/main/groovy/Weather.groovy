import groovy.json.*;

class Weather {
    
    private static final OPEN_WEATHER_MAP_EXAMPLE_APPID = '2de143494c0b295cca9337e1e96b00e0'
    private static JsonSlurper slurper = new JsonSlurper()

    static def getCurrentTemperature(city, state) {
        String jsonOutput = getWeatherData 'weather', '${city},${state}'
        convertToFahrenheit slurper.parseText(jsonOutput).main.temp
    }
    
    static def getCurrentConditions(city, state) {
         String jsonOutput = getWeatherData 'weather', '${city},${state}'
         slurper.parseText(jsonOutput).weather.description
    }

    static def getFiveDayForecast(city, state) {
         String jsonOutput = getWeatherData 'forecast/daily', '${city},${state}'
         def returnList = []
         slurper.parseText(jsonOutput).list.each {
             returnList << it.temp.day
         }
         returnList.dropRight 2
    }

    static private def getWeatherData(key, value) {
        String jsonOutput = "http://api.openweathermap.org/data/2.5/${key}?q=${value}&appid=${OPEN_WEATHER_MAP_EXAMPLE_APPID}".toURL().text
    }
    
    static private def convertToFahrenheit(kelvinTemp) {
        (kelvinTemp - 273.15) * 1.80 + 32.00
    }
}
