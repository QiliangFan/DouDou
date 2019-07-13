# 豆豆电影

#### Cops： Sun Xiaojie \ Fan Qiliang

### tools: eclipse

#### db: mysql 5.5

#### server: Ubuntu 18.04LTS

#### jdk: openjdk-1.8

to start a tomcat :  
    in  /config/server.xml
    add this:
    (depend on your own configuration:))
    
    <Host name="***.***.***.***"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">
        <Context path="/DouDou" docBase="/usr/local/apache-tomcat-9.0.21/webapps/DouDou/"  reloadable="true" />

        <!-- SingleSignOn valve, share authentication between web applications
             Documentation at: /docs/config/valve.html -->
        <!--
        <Valve className="org.apache.catalina.authenticator.SingleSignOn" />
        -->

        <!-- Access log processes all example.
             Documentation at: /docs/config/valve.html
             Note: The pattern used is equivalent to using pattern="common" -->
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log" suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />

      </Host>
        
