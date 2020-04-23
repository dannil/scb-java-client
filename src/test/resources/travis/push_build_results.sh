#!/bin/sh

setup_git() {
  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "Travis CI"
}

setup_remote() {
  git remote add origin/build-results https://${GH_TOKEN}@github.com/dannil/scb-java-client.git > /dev/null 2>&1
  git fetch origin/build-results
}

create_folder() {
  now=$(date '+%Y-%m-%d_%H-%M-%S')
  mkdir $now
  cp target/site/jacoco $now -r
  cp target/japicmp $now -r
}

commit() {
  git checkout build-results
  git add .
  git commit --message "Travis build $TRAVIS_BUILD_NUMBER"
}

push() {
  git push --set-upstream origin/build-results build-results
}

setup_git
setup_remote
create_folder
commit
push
