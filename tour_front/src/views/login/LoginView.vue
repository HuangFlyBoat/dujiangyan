<template>
  <div class="container">
    <div class="card-box">
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
                <el-button :loading="isLoading" style="width: 100%" type="primary" @click="onSubmitLogin"
                  >登录</el-button
                >
              </el-form-item>
            </el-form>
          </el-tab-pane>
          <el-tab-pane label="注册" name="second">
            <el-form ref="formRef" :rules="rules" :model="form" label-width="80px">
              <el-form-item label="用户名" prop="userName">
                <el-input v-model="form.userName" />
              </el-form-item>
              <el-form-item label="邮箱" prop="email">
                <el-input v-model="form.email"
                />
              </el-form-item>
              <el-form-item label="手机号" prop="phone">
                <el-input v-model="form.phone"
                />
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
                  v-model="form.password2"
                />
              </el-form-item>
              <el-form-item label="性别">
                <el-radio-group v-model="form.userSex">
                  <el-radio label="男" :value="0" />
                  <el-radio label="女" :value="1" />
                </el-radio-group>
              </el-form-item>
              <el-form-item>
                <el-button :loading="isLoading" style="width: 100%" type="primary" @click="onSubmitRegister"
                  >注册</el-button
                >
              </el-form-item>
            </el-form>
          </el-tab-pane>
        </el-tabs>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { login, register } from '@/apis/login.js'
import { ElMessage } from 'element-plus'
const formRef = ref()
const activeName = ref('first')
const form = ref({
  userName: '',
  password: '',
  password2: '',
  userSex: 0,
  email: '',
  phone: ''
})

const rules = reactive({
  userName: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 3, max: 20, message: '长度控制在3-20以内', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 8, max: 20, message: '长度控制在8-20以内', trigger: 'blur' }
  ],
  email: [
    { required: true, message: '请输入邮箱', trigger: 'blur' },
    { min: 3, max: 20, message: '长度控制在3-20以内', trigger: 'blur' }
  ],
  phone: [
    { required: true, message: '请输入手机号', trigger: 'blur' },
    { min: 3, max: 20, message: '长度控制在3-20以内', trigger: 'blur' }
  ]
})

const isLoading = ref(false)

const handleClick = (tab) => {
  if (activeName.value !== tab.paneName) {
    form.value = {
      userName: '',
      password: '',
      password2: '',
      gender: 0,
      email: '',
      phone: ''
    }
  }
}

const onSubmitRegister = async () => {
  console.log(form.value)
  if (!formRef.value) return
  await formRef.value.validate(async (valid, fields) => {
    if (valid) {
      isLoading.value = true
      await register(form.value)
      isLoading.value = false
      ElMessage.success('注册成功')
      handleClick('first')
    } else {
      console.log('error submit!', fields)
    }
  })
}

const onSubmitLogin = async () => {
  if (form.value.userName === '' || form.value.password === '') {
    ElMessage.error('请输入账号或者密码')
    return
  }
  isLoading.value = true
  const res = await login(form.value)
  isLoading.value = false
  ElMessage.success('登录成功')
  localStorage.setItem('userName', res.userName)
  localStorage.setItem('userId', res.userId)
  location.replace('/')
}
</script>

<style lang="scss" scoped>
.container {
  position: relative;
  width: 100%;
  height: 100vh;
  background-image: url(../../assets/loginBg.jpg);
  background-repeat: no-repeat;
  background-size: 100% 100%;
}
.card-box {
  padding: 30px;
  margin:  180px auto 0 auto;
  width: 600px;
  border-radius: 10px;
  background-color: #0f232f69;
}

.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
</style>
