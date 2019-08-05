# Bash Dataflow

Dataflow read file with 19k rows from storage and extract top n gbk by nationality and save output in storage

## Ejectuar
java -jar storage-to-storage-dl.jar --project=[id de proyecto] --zone=us-central1-a --runner=DataflowRunner --numWorkers=1 --workerMachineType=n1-standard-1
