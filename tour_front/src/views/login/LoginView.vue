<template>
  <div class="container">
    <div class="left">
    </div>
    <el-card class="box-card">
      <div class="right">
        <el-tabs
          v-model="activeName"
          class="demo-tabs"
          @tab-click="handleClick"
        >
          <el-tab-pane label="登录" name="first">
            <el-form :model="form" label-width="60px">
              <el-form-item label="用户名">
                <el-input v-model="form.userName" />
              </el-form-item>
              <el-form-item label="密码">
                <el-input
                  type="password"
                  autocomplete="off"
                  v-model="form.password"
                />
              </el-form-item>
              <el-form-item>
                <el-button style="width: 100%" type="primary" @click="onSubmit"
                  >登录</el-button
                >
              </el-form-item>
            </el-form>
          </el-tab-pane>
          <el-tab-pane label="注册" name="second">
            <el-form :rules="rules" :model="form" label-width="80px">
              <el-form-item label="用户名" prop="userName">
                <el-input v-model="form.userName" />
              </el-form-item>
              <el-form-item label="密码" prop="password">
                <el-input
                  type="password"
                  autocomplete="off"
                  v-model="form.password"
                />
              </el-form-item>
              <el-form-item label="确认密码" prop="password">
                <el-input
                  type="password"
                  autocomplete="off"
                  v-model="form.password"
                />
              </el-form-item>
              <el-form-item label="性别">
                <el-radio-group v-model="form.userSex">
                  <el-radio label="男" />
                  <el-radio label="女" />
                </el-radio-group>
              </el-form-item>
              <el-form-item>
                <el-button style="width: 100%" type="primary" @click="onSubmit"
                  >注册</el-button
                >
              </el-form-item>
            </el-form>
          </el-tab-pane>
        </el-tabs>
      </div>
    </el-card>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'

const activeName = ref('first')
const form = ref({
  userName: '',
  password: '',
  userSex: '男'
})

const rules = reactive({
  userName: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 3, max: 20, message: '长度控制在3-20以内', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 8, max: 20, message: '长度控制在8-20以内', trigger: 'blur' }
  ]
})

const handleClick = (tab) => {
  if (activeName.value !== tab.paneName) {
    form.value = {
      userName: '',
      password: '',
      userSex: '男'
    }
  }
}

const onSubmit = () => {
  console.log('submit!')
}
</script>

<style lang="scss" scoped>
.container {
  position: relative;
  width: 100%;
  height: 100vh;
  .left {
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    background-image: url(../../assets/loginBg.jpg);
    background-repeat: no-repeat;
    background-size: 100% 100%;
  }
  .right {
    padding: 150px 200px;
  }
}
.box-card {
  width: 100%;
  height: 580px;
}

.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
</style>
