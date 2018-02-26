package leasure

import akka.actor.SupervisorStrategy.{Restart, Stop}
import akka.actor.{Actor, ActorSelection, ActorSystem, OneForOneStrategy, Props}
import akka.pattern._

import scala.concurrent.duration._

/**
  * Created by chenteng on 2017/2/28.
  */

object TestActor {
  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem("TestSystem")
//    val childRef = actorSystem.actorOf(Props[Child],"child")
    val supervisor = actorSystem.actorOf(Props[Supervisor], "supervisor")
    supervisor ! (Props[Child],"child")
    val childRef = actorSystem.actorSelection("/user/supervisor/child")
    childRef ! Message("this is test msg 1")
    Thread.sleep(3000)
    childRef ! Message("this is test msg 2")

  }
}

class Supervisor extends Actor {
  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
      case _: WantToRestartException =>{
        println("supervisor restart exception!!!")
        Restart
      }
      case _: Exception => Stop
    }

  override def receive: Receive = {
    case p: (Props,String) => sender() ! context.actorOf(p._1,p._2)
  }
}


class Child extends Actor {
  override def receive: Receive = {
    case Message(msg) => {
      println(s"childActor receive msg:${msg}")
      throw new WantToRestartException
    }
  }

  @scala.throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    super.preStart()
    println(self.path)
    println(self.getClass.toString)
    println("childActor preStart method execute")
  }

  @scala.throws[Exception](classOf[Exception])
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    super.preRestart(reason, message)
    println("childActor preRestart method execute")
  }
}

@SerialVersionUID(0L)
case class Message(msg: String)

class WantToRestartException extends Exception
