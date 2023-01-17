#!/bin/bash

mkdir --parents "$HOME/.ssh"
DEPLOY_KEY_FILE="$HOME/.ssh/deploy_key"
echo "${SSH_PUSH_KEY}" > "$SSH_PUSH_KEY"
chmod 600 "$SSH_PUSH_KEY"

SSH_KNOWN_HOSTS_FILE="$HOME/.ssh/known_hosts"
ssh-keyscan -H "$1" > "$SSH_KNOWN_HOSTS_FILE"

export GIT_SSH_COMMAND="ssh -i "$DEPLOY_KEY_FILE" -o UserKnownHostsFile=$SSH_KNOWN_HOSTS_FILE"

git push --mirror -f $2
