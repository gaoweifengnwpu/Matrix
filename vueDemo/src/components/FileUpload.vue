<template>
  <el-upload
    action="http://192.168.2.11:8082/upload"
    :on-preview="handlePreview"
    multiple
    :limit="10"
    accept=".png">
    <el-button size="small" type="primary">点击上传</el-button>
    <div slot="tip" class="el-upload__tip">只能上传png文件，且不超过100MB</div>
  </el-upload>
</template>
