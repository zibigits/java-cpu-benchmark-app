<h3 align="center">
Hi there, I'm <a href="https://itadmin.vblog.ovh/" target="_blank" rel="noreferrer">Zibi</a> 👋
</h3>

<h2 align="center">
I'm a DevOps engineer 💻, video amateur 📸, and amateur programmer 📝!
</h2> 

I am fascinated by the whole process of implementing the application from the code to running it in the cluster.

### 🤝 Connect with me:

<a href="https://www.linkedin.com/in/zbigniew-roszewski-43b204123/">Zbigniew Roszewski | LinkedIn</a>

- 💬 If you have any question/feedback, please do not hesitate to reach out to me!

## 🔭 I'm currently working on

- Fancy Java apps
- Useful Ansible-playbooks
- Useful Bash script for Icinga and Zabbix monitoring
- Multi-purpose python applications
- My blog https://itadmin.vblog.ovh/

## 🌱 I'm currently learning

- Docker container
- Kubernetes cluster
- OpenShift cluster
- Icinga 2 & Zabbix monitoring
- Elasticsearch & Kibana
- Java / Python / Bash script

## 📝 Latest Blog Posts

- [Przykład aplikacji Java CPU Benchmark Example umieszczonej na github.com](https://itadmin.vblog.ovh/przyklad-aplikacji-java-cpu-benchmark-example-umieszczonej-na-github-com/)
- [Przygotowanie obrazu Docker z aplikacją Java do wysłania na hub.docker.com](https://itadmin.vblog.ovh/przygotowanie-obrazu-docker-z-aplikacja-java-do-wyslania-na-hub-docker-com/)
- [Przykład aplikacji Java odczytującej z bazy danych MariaDB](https://itadmin.vblog.ovh/przyklad-aplikacji-java-odczytujacej-z-bazy-danych-mariadb/)
- [Przykład aplikacji Java zapisującej do bazy danych MariaDB](https://itadmin.vblog.ovh/przyklad-aplikacji-java-zapisujacej-do-bazy-danych-mariadb/)

## 📈 GitHub Stats 

[![Github stats](https://github-readme-stats.vercel.app/api?username=kazzuja)](https://github.com/kazzuja)


## 🔭 About this app

Simple Java application for determining cpu performance.
The application runs in an infinite loop and returns the following result:

_Elapsed Time: 4249 milliseconds (hihger is worse)_
_System score: 957 (hihger is better)_

This Java application can be run from a container with Java software.

1) create jar file<br /><br />
_jar cfmv CPUBenchmarkExample.jar Manifest.txt CPUBenchmarkExample.class_
<br />
2) create Manifest.txt<br /><br />
<sub>
Manifest-Version: 1.0<br />
Main-Class: CPUBenchmarkExample<br />
</sub>
<br />
3) create Docker file:<br /><br />
<sub>
FROM openjdk:11<br />
COPY CPUBenchmarkExample.jar /opt<br />
ENV TZ="Europe/Warsaw"<br />
ENV JAVA_OPTS=""<br />
ENV APP_OPTIONS=""<br />
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /opt/CPUBenchmarkExample.jar $APP_OPTIONS" ]
</sub>

4) build docker image<br /><br />
_docker build -t java-cpu-benchmark-img:1.0 ._

5) run container based on image. If you have 1 CPU, the following commands guarantees the container at most 20% of the CPU.<br /><br />
_docker run -d --cpus=".2" --name java-cpu-benchmark-app java-cpu-benchmark-img:1.0_# -java-cpu-benchmark-app
# java-cpu-benchmark-app
