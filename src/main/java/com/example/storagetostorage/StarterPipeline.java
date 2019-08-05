/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.storagetostorage;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.Top;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;

import com.example.storagetostorage.option.StarterPipelineOptions;
import com.example.storagetostorage.transform.GkbToStringBestTransform;
import com.example.storagetostorage.transform.PlayerToKeyValueTransform;
import com.example.storagetostorage.transform.StringToPlayerTransform;
import com.example.storagetostorage.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StarterPipeline {

    public static void main(String[] args) {
        log.info(Constants.START_PROCESS);


        StarterPipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(StarterPipelineOptions.class);
        Pipeline p = Pipeline.create(options);

        PCollection<KV<String,Long>> countPerKey = p.apply(Constants.READ_CSV, TextIO.read().from(options.getInputFile()))
         .apply(Constants.LINE_TO_PLAYER, new StringToPlayerTransform())
         .apply(Constants.PLAYER_TO_KV, new PlayerToKeyValueTransform())
         .apply(Constants.COUNT_BY_NAT, Count.perKey());
        
        countPerKey.apply(Constants.BEST+Constants.NUMBER_TOP, Top.<KV<String,Long>, KV.OrderByValue<String,Long>>of(Constants.NUMBER_TOP, new KV.OrderByValue<String,Long>()).withoutDefaults())
         .apply(Constants.GBK_TO_STRING, new GkbToStringBestTransform())
         .apply(Constants.WRITE_OUTPUT, TextIO.write().to(options.getOutputBestFile()).withSuffix(Constants.EXTENSION_CSV).withoutSharding());

        p.run().waitUntilFinish();

        log.info(Constants.FINISHED_PROCESS);
    }
}
