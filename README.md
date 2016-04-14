karaf.example
=============

Beispielapp in Karaf

Vorbereitung
------------

	karaf@root()> feature:install jpa
	karaf@root()> feature:install jta
	Error executing command: No feature named 'jta' with version '0.0.0' available
	karaf@root()> feature:install jndi
	karaf@root()> feature:install transaction
	karaf@root()> feature:install jdbc
	karaf@root()> bundle:install -s mvn:com.h2database/h2/1.3.167
	Bundle ID: 98
	karaf@root()> 

TODO
====
* https://github.com/FunThomas424242/karaf.example/pull/1
*

