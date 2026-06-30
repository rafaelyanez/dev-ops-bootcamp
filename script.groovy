def build() {
  echo "building the application..."
  sh "mvn package"
}
def createImage() {

  echo "building docker image..."
  withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
  sh 'echo $PASSWORD'
  sh 'echo $USERNAME'
  sh 'docker build -t 165.227.47.37:8083/java-app:1.0 .'

  // sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin 165.227.47.37:8083'
  // sh 'docker push 165.227.47.37:8083/java-app:1.0'
  }
}
return this
true
