#!/bin/sh
# wait-for.sh

set -e

host="$1"
shift
cmd="$@"

until nc -z "$host" 27017; do
  echo "Waiting for MongoDB..."
  sleep 2
done

exec $cmd