#!/bin/bash
# If compiled python files exist, remove them
if [ -f *.pyc ]; then
  rm *.pyc
fi

# Run all test files
for f in *Test.py; do
  python $f
done

# Remove all compiled python files for clean version control
if [ -f *.pyc ]; then
  rm *.pyc
fi
