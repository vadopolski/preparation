source_file_name=$1
cur_date_d1=$2

echo "CUR DATE D1"
echo $cur_date_d1

echo "CREATING NEW FOLDER"
hdfs dfs -mkdir /user/vopolski/test_target/cur_date=${cur_date_d1}

# 4c8617af-d268-46d0-bfe1-10f069ed7b9d-c000.csv

echo "DOWNLOADING NEW DATA"
hadoop distcp s3://eas-015-lux-train/taxi-source/${source_file_name} /user/vopolski/test_target/cur_date=${cur_date_d1}