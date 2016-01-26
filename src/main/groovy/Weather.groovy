import groovy.json.*;

class Weather {
    
    // TODO - pass in appId as a command line property
    private static final OPEN_WEATHER_MAP_EXAMPLE_APPID = 'e09874c013ded6bf8330a86122ba49c9'

    static getCurrentTemperature(city, state) {
        JsonSlurper slurper = new JsonSlurper()
        String jsonOutput = getWeatherData 'weather', '${city},${state}'

        convertToFahrenheit slurper.parseText(jsonOutput).main.temp
    }
    
    static getCurrentConditions(city, state) {
         JsonSlurper slurper = new JsonSlurper()
         String jsonOutput = getWeatherData 'weather', '${city},${state}'

         slurper.parseText(jsonOutput).weather.description
    }

    static getFiveDayForecast(city, state) {
        JsonSlurper slurper = new JsonSlurper()
         String jsonOutput = getWeatherData 'forecast/daily', '${city},${state}'
         
         slurper.parseText(jsonOutput).list.collect { it.temp.day }.dropRight(2)
    }

    static private getWeatherData(key, value) {
        String jsonOutput = "http://api.openweathermap.org/data/2.5/${key}?q=${value}&appid=${OPEN_WEATHER_MAP_EXAMPLE_APPID}".toURL().text
    }
    
    static private convertToFahrenheit(kelvinTemp) {
        (kelvinTemp - 273.15) * 1.80 + 32.00
    }
}
