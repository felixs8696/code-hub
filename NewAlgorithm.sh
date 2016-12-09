#!/bin/bash
folder="None"
PS3='Select A Folder: '
options=(`ls -d Algorithms/* | sed 's:.*/::'`)
select opt in "${options[@]}" "Quit"
do
  case "$REPLY" in
    $(( ${#options[@]}+1 )) )
      echo "Exiting..."
      exit 1
      ;;
    *)
      if [[ $REPLY -ge 1 && $REPLY -le ${#options[@]} ]]; then
        folder=$opt
        folder=$folder | sed -E "s~(^|\s)(.)~\U\2~g"
        echo  -e "Selected '$folder'\n"
      else
        echo "Invalid option.";
        exit 1
      fi
      break;;
  esac
done

topic="None"
folders=(`ls -d Algorithms/Challenges/* | sed 's:.*/::'`)

PS3="Select A Topic: "
select opt in "NEW" "${folders[@]}"
do
  case "$REPLY" in
    1 )
      echo -n "New Topic: "
      read topic
      topic=$topic | sed -E "s~(^|\s)(.)~\U\2~g"
      echo  -e "Created new topic '$topic'\n"
      break;;
    *)
      if [[ $REPLY -ge 1 && $REPLY -le ${#folders[@]} ]]; then
        topic=$opt
        topic=$topic | sed -E "s~(^|\s)(.)~\U\2~g"
        echo  -e "Selected '$topic'\n"
      else
        echo "Invalid option.";
        exit 1
      fi
      break;;
  esac
done

if [[ $topic != "None" && ! -d Algorithms/$folder/$topic ]]; then
  echo -n "New Algorithm: "
  read algorithm
  algorithm=$algorithm | sed -E "s~(^|\s)(.)~\U\2~g"

  alg_dir=Algorithms/$folder/$topic/$algorithm
  echo "Creating folder '$alg_dir' and its starter files..."
  mkdir -p $alg_dir;
  mkdir -p $alg_dir/Java;
  mkdir -p $alg_dir/Python;
  # echo >$alg_dir/Python/$algorithm.py
  cp Templates/Bash/RunJUnitTests.sh $alg_dir/Java/RunJUnitTests.sh
  cp Templates/Bash/RunJUnitTests.sh $alg_dir/Python/RunPyUnitTests.sh

  # Create Java Starter Files
  cp -rf Templates/Java/BufferedIO/io $alg_dir/Java/io
  cp Templates/Java/BufferedIO/BufferedIOTemplate.java $alg_dir/Java/$algorithm.java
  perl -pi -e "s/BufferedIOTemplate/$algorithm/g" $alg_dir/Java/$algorithm.java

  # Create Python Starter Files
  cp -rf Templates/Python/FileIO/io $alg_dir/Python/io
  cp Templates/Python/FileIO/fileio.py $alg_dir/Python/$algorithm.py
  cp Templates/Python/UnitTest/ExampleTest.py $alg_dir/Python/${algorithm}Test.py
  perl -pi -e "s/Example/$algorithm/g" $alg_dir/Python/${algorithm}Test.py

else
  echo "Folder for $topic already exists."
  exit 1
fi