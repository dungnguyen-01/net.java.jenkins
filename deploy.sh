echo -e "Welcome to build project net.java.jenkins";

echo "waiting 10s..."

for i in {1..10}; do
  echo "$i s"
  sleep 1;
done

echo -e "1. mvn clean"
mvn clean


echo -e "2. mvn update"
mvn update

echo -e "3. mvn install"
mvn install


echo "waiting 3s"

sleep 3;

docker build -t net.java.jenkins .
echo -e 'build successfully images net.java.jenkins'

echo 'waiting run container from images net.java.jenkins'

docker run -dp 6060:6060 --name net.java.jenkins_container net.java.jenkins

echo -e 'build and run  successlly.'



