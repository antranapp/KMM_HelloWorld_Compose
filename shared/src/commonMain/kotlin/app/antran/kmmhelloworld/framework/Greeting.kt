package app.antran.kmmhelloworld.framework

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}