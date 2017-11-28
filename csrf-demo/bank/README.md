# CSRF Demo

## Prerequisites

* JDK 1.8
* Apache Maven
* Make sure port 80 is available (e.g. disable nginx, haproxy, apache2, etc.)
* Add bank.com domain to /etc/hosts:
```
$ sudo sh -c "echo '127.0.0.1 bank.com' >> /etc/hosts"
```

## Building

```
$ mvn install
```

## Running

```
$ sudo java -jar target/bank-1.0-SNAPSHOT.jar
```

## Usage

* Navigate to http://bank.com.
* Sign in as `lorem` / `ipsum`.
* Open hacker's examples:
    * [hacker1](../hacker1.html)
    * [hacker2](../hacker2.html)
    * [hacker3](../hacker3.html)
