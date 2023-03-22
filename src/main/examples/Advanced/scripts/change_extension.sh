#!/bin/bash
find /Users/quese/Projects23/techbeez/PracticeJava-23 -type f -name '*.class' -print0 | while read -d '' -r file; do
  mv -- "$file" "${file%.class}.java"
done
