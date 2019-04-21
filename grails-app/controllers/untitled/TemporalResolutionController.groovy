package untitled

import org.grails.web.json.JSONObject

class TemporalResolutionController {
    def stanfordNlpCoreService

    def index() {}

    def parseDate() {
        def parsedDate = stanfordNlpCoreService.temporalResolutionWithSuTime(params.text)
        render parsedDate
    }
}
