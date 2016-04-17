# CHANGES

## 1.0.1-SNAPSHOT

* pull request #1 by gmlewis (Glenn Lewis)
  <p>
Upgrade Apache Commons Collections to v3.2.2 
Version 3.2.1 has a CVSS 10.0 vulnerability. That is the worst kind of
vulnerability that exists. By merely existing on the classpath, this
library causes the Java serialization parser for the entire JVM process
to go from being a state machine to a turing machine. A turing machine
with an exec() function!
</p><p>
https://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2015-8103
https://commons.apache.org/proper/commons-collections/security-reports.html
http://foxglovesecurity.com/2015/11/06/what-do-weblogic-websphere-jboss-jenkins-opennms-and-your-application-have-in-common-this-vulnerability/
</p>

## 1.0.0-SNAPSHOT

* initializing project
* karaf-3.0.1 supported
* jpa command example
