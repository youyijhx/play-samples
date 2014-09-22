package controllers

import models.Greeting
import play.api.Play.current
import play.api.i18n.Lang
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import play.twirl.api.Html
import services.GreetingService

class GreeterController(greetingService: GreetingService) extends Controller {

  val greetingsList = Seq(
    Greeting(1, greetingService.greetingMessage("en"), "sameer"),
    Greeting(2, greetingService.greetingMessage("it"), "sam")
  )

  def greetings = Action {
    Ok(Json.toJson(greetingsList))
  }

  def greetInMyLanguage = Action {
    Ok(greetingService.greetingMessage(Lang.availables.head.language))
  }

  def index = Action {
    Ok(Html("<h1>Welcome</h1><p>Your new application is ready.</p>"))
  }

}
