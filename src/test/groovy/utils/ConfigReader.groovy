package utils

class ConfigReader {

    def static env = "test"

    static ConfigObject getConfiguration() {
        def env = System.getProperty("geb.profile")

        if (env) {
            this.env = env
        }

        def config = new ConfigSlurper(this.env)
                .parse(new File('src//test//resources//Url.groovy').toURI().toURL())

        def loginFlowConfig = new ConfigSlurper(this.env)
                .parse(new File('src//test//resources//LoginInfo.groovy').toURI().toURL())

        config.loginInfo = loginFlowConfig

        config
    }
}
