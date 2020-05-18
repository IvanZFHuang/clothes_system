<template>
  <div>
    <div style="display: flex;justify-content: space-between">
      <div>
        <el-input
          placeholder="请输入顾客名进行搜索，可以直接回车搜索..."
          prefix-icon="el-icon-search"
          :clearable="true"
          style="width: 350px;margin-right: 10px"
          @clear="listClothes"
          v-model="keyword"
          @keydown.enter.native="listClothes"
          :disabled="showAdvanceSearchView"
        ></el-input>
        <el-button icon="el-icon-search" type="primary" @click="fuzzyQuery">搜索</el-button>
      </div>
      <div>
        <el-button type="primary" icon="el-icon-plus" @click="showAddDialog">收衣(会员)</el-button>
        <el-button type="info" icon="el-icon-plus" @click="showAddDialog1">收衣(非会员)</el-button>
      </div>
    </div>
    <div style="margin-top:10px">
      <el-table
        :data="tableData"
        element-loading-text="正在加载..."
        element-loading-spinner="el-icon-loading"
        element-loading-background="rgba(0, 0, 0, 0.8)"
        style="width: 100%"
        border
        highlight-current-row:true
      >
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-row :gutter="20">
                <el-col :span="6">
                  <el-form-item label="衣物瑕疵:">
                    <span>{{ props.row.clothesFlow }}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="衣服附件:">
                    <span>{{ props.row.clothesAdjunct }}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="衣服品牌:">
                    <span>{{ props.row.clothesBrand }}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="衣服颜色:">
                    <span>{{ props.row.clothesColor }}</span>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row :gutter="20">
                <el-col :span="6">
                  <el-form-item label="会员号:">
                    <span>{{ props.row.memberNum }}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="会员余额:">
                    <span>{{ props.row.balance }}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="收衣时间:">
                    <span>{{ props.row.putClothesTime }}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="预计完成时间:">
                    <span>{{ props.row.preTime}}</span>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row :gutter="20">
                <el-col :span="6" v-if="props.row.takeClothesTime">
                  <el-form-item label="取衣时间:">
                    <span>{{ props.row.takeClothesTime }}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="6" v-if="props.row.washReason">
                  <el-form-item label="重洗原因:">
                    <span>{{ props.row.washReason }}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="6" v-if="props.row.foundReason">
                  <el-form-item label="赔偿原因:">
                    <span>{{ props.row.foundReason }}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="6" v-if="props.row.foundAmount">
                  <el-form-item label="赔偿金额:">
                    <span>{{ props.row.foundAmount }}</span>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column prop="clothesNum" label="挂衣号" width="80"></el-table-column>
        <el-table-column prop="typeName" label="类型名称"></el-table-column>
        <el-table-column prop="cusName" label="顾客姓名"></el-table-column>
        <el-table-column prop="cusPhone" label="顾客手机号" width="100"></el-table-column>
        <el-table-column prop="memTypeName" label="会员类型"></el-table-column>
        <el-table-column prop="typePrice" label="洗衣价格" width="80"></el-table-column>
        <el-table-column prop="discount" label="会员折扣" width="100"></el-table-column>
        <el-table-column prop="realPrice" label="实际收费" width="80"></el-table-column>
        <el-table-column prop="progress" label="洗衣进度" width="100">
          <template slot-scope="scope">
                        <el-tag type="info" v-if="scope.row.progress=='正在洗'">正在洗</el-tag>
                        <el-tag  v-else-if="scope.row.progress=='已洗完'">已洗完</el-tag>
                        <el-tag type="success" v-else-if="scope.row.progress=='已取衣'">已取衣</el-tag>
                        <el-tag type="warning" v-else-if="scope.row.progress=='已重洗'">已重洗</el-tag>
                        <el-tag type="danger" v-else-if="scope.row.progress=='已赔偿'">已赔偿</el-tag>
                    </template>
        </el-table-column>
        <el-table-column prop="name" label="操作人" width="100"></el-table-column>
        <el-table-column label="操作" width="300">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              @click="pay(scope.row)"
              style="padding: 3px"
              :disabled="scope.row.isPay==1"
            >付费</el-button>
            <el-button
              size="mini"
              type="success"
              @click="toTakeClothes(scope.row)"
              style="padding: 3px"
            >已洗完</el-button>
            <el-button
              size="mini"
              type="success"
              @click="takeClothes(scope.row)"
              style="padding: 3px"
              v-bind:disabled="scope.row.isTake==1"
            >取衣</el-button>
            <el-button size="mini" type="warning" @click="rewash(scope.row)" style="padding: 3px">重洗</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="refound(scope.row)"
              style="padding: 3px"
            >退赔</el-button>
            <el-button
              size="mini"
              type="info"
              @click="remindCustomer(scope.row)"
              style="padding: 3px"
            >提醒取衣</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- 分页的组件 -->
    <div style="display: flex;justify-content: flex-end;margin-top:20px">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :background="true"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </div>
    <!-- 会员收衣的模态框 -->
    <div>
      <el-dialog title="会员顾客" :visible.sync="dialogVisible" width="60%">
        <el-form ref="clothesForm" :model="clothesForm" label-width="100px" :rules="rules1">
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="衣服类型" prop="typeId">
                  <el-select
                    v-model="clothesForm.typeId"
                    placeholder="请选择衣服类型"
                    :clearable="true"
                    @change="selectPrice"
                  >
                    <el-option
                      v-for="item in clothesTypePrice"
                      :key="item.typeId"
                      :value="item.typeId"
                      :label="item.typeName"
                    ></el-option>
                  </el-select>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="洗衣标价">
                  <el-input :value="price"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="衣服颜色" prop="clothesColor">
                  <el-input v-model="clothesForm.clothesColor"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple" prop="clothesBrand">
                <el-form-item label="衣服品牌">
                  <el-input v-model="clothesForm.clothesBrand"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="有无瑕疵" prop="clothesFlow">
                  <el-input v-model="clothesForm.clothesFlow"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="有无附件" prop="clothesAdjunct">
                  <el-input v-model="clothesForm.clothesAdjunct"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="顾客姓名" prop="cusName">
                  <el-select
                    v-model="clothesForm.customerId"
                    placeholder="请选择顾客"
                    :clearable="true"
                    @change="selectCustomer"
                  >
                    <el-option
                      v-for="item in customer"
                      :key="item.cusId"
                      :value="item.cusId"
                      :label="item.cusName"
                    ></el-option>
                  </el-select>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="手机号" prop="cusPhone">
                  <el-input v-model="cusPhone"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="邮箱" prop="cusEmail">
                  <el-input v-model="cusEmail"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple-light">
                <el-form-item label="会员类型">
                  <el-input v-model="memTypeName"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="会员折扣">
                  <el-input v-model="discount"></el-input>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="实际收费" prop="realPrice">
                  <el-input v-model="clothesForm.realPrice"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="预计完成时间" prop="preTime">
                  <el-date-picker
                    v-model="clothesForm.preTime"
                    type="datetime"
                    placeholder="选择日期时间"
                    value-format="yyyy-MM-dd HH:mm:ss"
                  ></el-date-picker>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple">
                <el-form-item label="操作人">
                  <el-select
                    v-model="clothesForm.empId"
                    placeholder="请选择操作人"
                    :clearable="true"
                    @change="selectCustomer"
                  >
                    <el-option
                      v-for="item in employee"
                      :key="item.id"
                      :value="item.id"
                      :label="item.name"
                    ></el-option>
                  </el-select>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="closeAddDialog">取 消</el-button>
          <el-button type="primary" @click="addSalaryInfo">确 定</el-button>
        </span>
      </el-dialog>
    </div>
    <!-- 非会员收衣 -->
    <div>
      <el-dialog title="非会员顾客" :visible.sync="dialogVisible1" width="60%">
        <el-form ref="nomemForm" :model="nomemForm" label-width="100px" :rules="rules1">
          <div style="padding-left:100px;margin-bottom:30px">
            <el-button type="text" size="medium" @click="registerMem">去注册会员</el-button>
            <el-button type="text" size="medium" @click="notNeed">不需要会员</el-button>
          </div>
          <div v-if="showAdd">
            <el-row>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="衣服类型" prop="typeId">
                    <el-select
                      v-model="nomemForm.typeId"
                      placeholder="请选择衣服类型"
                      :clearable="true"
                      @change="selectPrice1"
                    >
                      <el-option
                        v-for="item in clothesTypePrice"
                        :key="item.typeId"
                        :value="item.typeId"
                        :label="item.typeName"
                      ></el-option>
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="洗衣标价">
                    <el-input :value="price1"></el-input>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="衣服颜色" prop="clothesColor">
                    <el-input v-model="nomemForm.clothesColor"></el-input>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="衣服品牌" prop="clothesBrand">
                    <el-input v-model="nomemForm.clothesBrand"></el-input>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="有无瑕疵" prop="clothesFlow">
                    <el-input v-model="nomemForm.clothesFlow"></el-input>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="grid-content bg-purple-light">
                  <el-form-item label="有无附件" prop="clothesAdjunct">
                    <el-input v-model="nomemForm.clothesAdjunct"></el-input>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="顾客姓名" prop="cusName">
                    <el-input v-model="nomemForm.cusName"></el-input>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="grid-content bg-purple-light">
                  <el-form-item label="手机号" prop="cusPhone">
                    <el-input v-model="nomemForm.cusPhone"></el-input>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="邮箱" prop="cusEmail">
                    <el-input v-model="nomemForm.cusEmail"></el-input>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="实际收费" prop="realPrice">
                    <el-input v-model="nomemForm.realPrice"></el-input>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="预计完成时间" prop="preTime">
                    <el-date-picker
                      v-model="nomemForm.preTime"
                      type="datetime"
                      placeholder="选择日期时间"
                      value-format="yyyy-MM-dd HH:mm:ss"
                    ></el-date-picker>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="grid-content bg-purple">
                  <el-form-item label="操作人">
                    <el-select v-model="nomemForm.empId" placeholder="请选择操作人" :clearable="true">
                      <el-option
                        v-for="item in employee"
                        :key="item.id"
                        :value="item.id"
                        :label="item.name"
                      ></el-option>
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
          </div>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="closeAddDialog1">取 消</el-button>
          <el-button type="primary" @click="addNoMemInfo">确 定</el-button>
        </span>
      </el-dialog>
    </div>
    <!-- 重洗 -->
    <div>
      <el-dialog title="衣服重洗" :visible.sync="dialogVisible3" width="50%">
        <el-form ref="rewashForm" :model="rewashForm" label-width="100px">
          <el-input v-model="rewashForm.clothesId" style="display:none"></el-input>
          <el-form-item label="挂衣号">
            <el-input v-model="reClothesNum" style="width:500px"></el-input>
          </el-form-item>
          <el-form-item label="重洗原因">
            <el-input type="textarea" v-model="rewashForm.reason" style="width:500px"></el-input>
          </el-form-item>
          <el-form-item label="预计完成时间" prop="preTime">
            <el-date-picker
              v-model="rewashForm.preTime"
              type="datetime"
              placeholder="选择日期时间"
              value-format="yyyy-MM-dd HH:mm:ss"
            ></el-date-picker>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="closeAddDialog2">取 消</el-button>
          <el-button type="primary" @click="confirmRewash">确 定</el-button>
        </span>
      </el-dialog>
    </div>
    <!-- 退赔 -->
    <div>
      <el-dialog title="衣服赔偿" :visible.sync="dialogVisible4" width="50%">
        <el-form ref="refoundForm" :model="refoundForm" label-width="100px">
          <el-input v-model="refoundForm.clothesId" style="display:none"></el-input>
         <el-form-item label="挂衣号">
            <el-input v-model="reClothesNum" style="width:500px"></el-input>
          </el-form-item>
          <el-form-item label="赔偿金额">
            <el-input type="text" v-model="refoundForm.refoundAmount" style="width:500px"></el-input>
          </el-form-item>
          <el-form-item label="赔偿原因">
            <el-input type="textarea" v-model="refoundForm.reason" style="width:500px"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="closeAddDialog3">取 消</el-button>
          <el-button type="primary" @click="confirmRefound">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: "SalSearch",
  data() {
    //手机号码验证
    const checkTel = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("请输入手机号码"));
      } else {
        const reg1 = /^[0-9]{1,20}$/;
        if (!reg1.test(value)) {
          return callback(new Error("请输入数字值"));
        } else {
          //截止2019/1/1 已开通的号段
          const reg2 = /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/;
          if (!reg2.test(value)) {
            console.log(1);
            return callback(new Error("请输入正确的手机号码"));
          }
          //验证是否已存在
          this.getRequest(
            "/customer/basic/getCountByPhone?phone=" + value
          ).then(result => {
            if (result.obj > 0) return callback(new Error("该手机号已注册"));
            else return callback();
          });
        }
      }
    };
    const checkChName = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("请输入姓名"));
      } else {
        const reg = /^[\u4E00-\u9FA5]{1,5}$/;
        if (!reg.test(value)) {
          return callback(new Error("请输入中文"));
        } else {
          return callback();
        }
      }
    };
    const checkType = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("请选择会员类型"));
      } else {
        return callback();
      }
    };
    // 自定义邮箱验证规则
    var checkEmail = (rule, value, callback) => {
      var reg = /^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/;
      if (value === "") {
        callback(new Error("请输入邮箱"));
      } else {
        if (reg.test(value)) {
          callback();
        } else {
          callback(new Error("请输入正确的邮箱"));
        }
      }
    };
    const clothesColor = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("衣服颜色不能为空"));
      } else {
        return callback();
      }
    };
    const clothesBrand = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("衣服品牌不能为空"));
      } else {
        return callback();
      }
    };
    const clothesFlow = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("请填写衣服是否有瑕疵"));
      } else {
        return callback();
      }
    };
    const clothesAdjunct = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("请填写衣服是否有附带品"));
      } else {
        return callback();
      }
    };
    const realPrice = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("实际收费不能为空"));
      } else {
        return callback();
      }
    };
    const preTime = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("预计完成时间不能为空"));
      } else {
        return callback();
      }
    };
    const empId = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("操作人不能为空"));
      } else {
        return callback();
      }
    };
    const typeId = (rule, value, callback) => {
      if (value === "") {
        return callback(new Error("衣服类型不能为空"));
      } else {
        return callback();
      }
    };
    return {
      //自定义+默认校验规则
      rules1: {
        cusName: [{ validator: checkChName, trigger: "blur" }],
        cusPhone: [
          { required: true, message: "请输入手机号码", trigger: "blur" },
          { validator: checkTel, trigger: "blur" }
        ],
        cusEmail: [{ required: true, validator: checkEmail, trigger: "blur" }],
        clothesColor: [
          { required: true, validator: clothesColor, trigger: "blur" }
        ],
        clothesBrand: [
          { required: true, validator: clothesBrand, trigger: "blur" }
        ],
        clothesFlow: [
          { required: true, validator: clothesFlow, trigger: "blur" }
        ],
        clothesAdjunct: [
          { required: true, validator: clothesAdjunct, trigger: "blur" }
        ],
        realPrice: [{ required: true, validator: realPrice, trigger: "blur" }],
        preTime: [{ required: true, validator: preTime, trigger: "blur" }],
        empId: [{ required: true, validator: empId, trigger: "blur" }],
        typeId: [{ required: true, validator: typeId, trigger: "blur" }]
      },
      // 接受后台返回的工资集合
      tableData: [],
      //总条数
      total: 0,
      //每页的条数
      pageSize: 10,
      //默认当前页
      pageNum: 1,
      showAdvanceSearchView: false,
      // 搜索时的关键字
      keyword: "",
      //控制对话框的显示与隐藏
      dialogVisible: false,

      // 添加工资条实例
      clothesForm: {
        typeId: "",
        customerId: "",
        clothesColor: "",
        clothesFlow: "",
        clothesAdjunct: "",
        clothesBrand: "",
        preTime: "",
        realPrice: "",
        empId: ""
      },
      memTypeName: "",
      discount: "",
      cusPhone: "",
      cusEmail: "",
      //洗衣标价
      price: "",
      price1: "",
      //隐藏id列
      showid: false,

      updateDialogVisible: false,
      //衣服类型和价钱
      clothesTypePrice: [],
      //查询所有的顾客
      customer: [],
      //所有的员工
      employee: [],
      // 控制非会员收衣的模态框
      dialogVisible1: false,
      dialogVisible4:false,
      showAdd: false,
      //非会员收衣表单
      nomemForm: {
        typeId: "",
        customerId: "",
        clothesColor: "",
        clothesFlow: "",
        clothesAdjunct: "",
        clothesBrand: "",
        preTime: "",
        realPrice: "",
        empId: "",
        cusPhone: "",
        cusEmail: "",
        cusName: ""
      },
      dialogVisible2: false,
      // 非会员付费
      nomemPay: false,
      //会员付费
      memPay: false,
      // 控制重洗的模态框
      dialogVisible3: false,
      // 重洗的表单
      rewashForm: {
        clothesId: "",
        reason: "",
        preTime: ""
      },
      // 重洗的挂衣号
      reClothesNum: "",
      // 退赔表单
      refoundForm:{
        clothesId:'',
        reason:'',
        refoundAmount:''
      }
    };
  },
  methods: {
    // 获取所有的工资
    listClothes() {
      console.log(this.keyword);
      let url =
        "/basic/clothes/listClothes?pageNum=" +
        this.pageNum +
        "&pageSize=" +
        this.pageSize;
      if (this.keyword != "" && this.keyword != null) {
        url += "&keyword=" + this.keyword;
      }
      this.getRequest(url).then(resp => {
        if (resp) {
          //console.log(resp);
          this.tableData = resp.obj;
          this.total = resp.obj1;
        }
      });
    },
    //删除
    handleDelete(row) {
      this.$confirm("此操作将永久删除【" + row.name + "】, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.deleteRequest("/salary/sob/delete/" + row.id).then(resp => {
            if (resp) {
              this.listClothes();
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    //编辑
    handleEdit(row) {
      console.log(row);
      this.updateDialogVisible = true;
      this.getRequest("/salary/sob/selectSalaryById?id=" + row.id).then(
        resp => {
          if (resp) {
            this.updateSalaryForm = resp.obj;
          }
        }
      );
    },
    //pageSize改变是触发
    handleSizeChange(newSize) {
      // console.log(newSize);
      this.pageSize = newSize;
      this.listClothes();
    },
    //pageNum  改变时触发
    handleCurrentChange(newNum) {
      // console.log(newNum);
      this.pageNum = newNum;
      this.listClothes();
    },
    //模糊查询
    fuzzyQuery() {
      this.listClothes();
    },

    updateAssignMent() {
      this.updateSalaryForm.allSalary =
        Number(this.updateSalaryForm.basicSalary) +
        Number(this.updateSalaryForm.bonus) +
        Number(this.updateSalaryForm.lunchSalary) +
        Number(this.updateSalaryForm.trafficSalary);
    },
    //显示添加的模态框
    showAddDialog() {
      this.listType();
      this.listCustomer();
      this.listEmployee();
      this.dialogVisible = true;
    },
    //添加收衣信息
    addSalaryInfo() {
      this.$refs.clothesForm.validate(valid => {
        if (valid) {
          this.postRequest(
            "/basic/clothes/insertClothes",
            this.clothesForm
          ).then(resp => {
            if (resp) {
              this.$refs.clothesForm.resetFields();
              this.dialogVisible = false;
              this.listClothes();
            }
          });
        }
      });
    },
    closeAddDialog() {
      this.$refs.clothesForm.resetFields();
      this.dialogVisible = false;
    },
    //关闭修改模态框
    closeUpdateDialog() {
      this.updateDialogVisible = false;
    },
    //提交修改信息
    commitUpdateForm() {
      this.$refs.updateSalaryForm.validate(valid => {
        if (valid) {
          this.putRequest("/salary/sob/update", this.updateSalaryForm).then(
            resp => {
              if (resp) {
                this.updateDialogVisible = false;
                this.listClothes();
              }
            }
          );
        }
      });
    },
    //查询所有的员工
    listCustomer() {
      this.getRequest("/customer/basic/listCustomer").then(resp => {
        if (resp) {
          this.customer = resp.obj;
        }
      });
    },
    //获取所有的衣服类型
    listType() {
      this.getRequest("/basic/clothes/listClothesType").then(resp => {
        if (resp) {
          this.clothesTypePrice = resp.obj;
        }
      });
    },
    //根据衣服类型查询标价
    selectPrice() {
      this.getRequest(
        "/basic/clothes/selectPrice?typeId=" + this.clothesForm.typeId
      ).then(resp => {
        if (resp) {
          this.price = resp.obj.typePrice;
        }
      });
    },
    //根据衣服类型查询标价
    selectPrice1() {
      this.getRequest(
        "/basic/clothes/selectPrice?typeId=" + this.nomemForm.typeId
      ).then(resp => {
        if (resp) {
          this.price1 = resp.obj.typePrice;
        }
      });
    },
    //根据客户id 查询客户的信息
    selectCustomer() {
      this.getRequest(
        "/customer/basic/selectCustomer?customerId=" +
          this.clothesForm.customerId +
          "&price=" +
          this.price
      ).then(resp => {
        if (resp) {
          this.memTypeName = resp.obj.memberType.typeName;
          this.discount = resp.obj.memberType.discount;
          this.cusPhone = resp.obj.customer.cusPhone;
          this.cusEmail = resp.obj.customer.cusEmail;
          this.clothesForm.realPrice = resp.obj1;
        }
      });
    },

    //查询所有的员工
    listEmployee() {
      this.getRequest("/employee/basic/listEmployee").then(resp => {
        if (resp) {
          this.employee = resp.obj;
        }
      });
    },
    // 非会员收衣
    showAddDialog1() {
      this.listType();
      this.listEmployee();
      this.dialogVisible1 = true;
    },

    //去注册会员
    registerMem() {
      this.$router.push("/mem/info");
    },
    //不需要会员
    notNeed() {
      this.showAdd = true;
    },
    // 添加非会员收衣
    addNoMemInfo() {
      this.$refs.nomemForm.validate(valid => {
        if (valid) {
          this.postRequest(
            "/basic/clothes/insertNomemClothes",
            this.nomemForm
          ).then(resp => {
            if (resp) {
              this.$refs.nomemForm.resetFields();
              this.dialogVisible1 = false;
              this.showAdd = false;
              this.listClothes();
            }
          });
        }
      });
    },
    // 关闭非会员收衣的模态框
    closeAddDialog1() {
      this.$refs.nomemForm.resetFields();
      this.dialogVisible1 = false;
    },
    // 跳转到付费页面
    pay(data) {
      if (data.memTypeName === null) {
        this.$router.push({
          path: "/serve/pay",
          query: {
            clothesNum: data.clothesNum,
            typeName: data.typeName,
            realPrice: data.realPrice,
            cusId: data.cusId,
            memberId: data.memberId,
            ismem: 1,
            clothesId: data.clothesId
          }
        });
      } else {
        this.$router.push({
          path: "/serve/pay",
          query: {
            typeName: data.typeName,
            realPrice: data.realPrice,
            cusId: data.cusId,
            clothesId: data.clothesId,
            cusName: data.cusName,
            memberType: data.memTypeName,
            balance: data.balance,
            ismem: 2,
            memberId: data.memberId
          }
        });
      }
    },
    // 取衣
    takeClothes(data) {
      if (!data.isPay) {
        this.$message.error("您还没有付费，请先付费在取衣");
      } else {
        this.$confirm("您是否要取走改衣服,是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        })
          .then(() => {
            this.putRequest(
              "/basic/clothes/takeClothes/" + data.clothesId
            ).then(resp => {
              if (resp) {
                this.listClothes();
              }
            });
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消取衣"
            });
          });
      }
    },
    // 衣服已经洗好
    toTakeClothes(data) {
      this.$confirm("您确定改衣服已经洗完,是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.putRequest("/basic/clothes/completed/" + data.clothesId).then(
            resp => {
              if (resp) {
                this.listClothes();
              }
            }
          );
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消"
          });
        });
    },
    // 重洗
    rewash(data) {
      this.$confirm("您确定改衣服已经洗完,是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.reClothesNum = data.clothesNum;
          this.rewashForm.clothesId = data.clothesId;
          this.dialogVisible3 = true;
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消"
          });
        });
    },
    // 确定重洗，提交表单
    confirmRewash() {
      this.postRequest("/basic/clothes/rewash/", this.rewashForm).then(resp => {
        if (resp) {
          this.dialogVisible3 = false;
          this.rewashForm = {};
          this.listClothes();
        }
      });
    },
    // 关闭重洗的模态框
    closeAddDialog2() {
      this.dialogVisible3 = false;
    },

    // 赔偿
    refound(data) {
      this.$confirm("您确定要赔偿,是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.reClothesNum = data.clothesNum;
          this.refoundForm.clothesId = data.clothesId;
          this.dialogVisible4 = true;
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消"
          });
        });
    },
    // 确定重洗，提交表单
    confirmRefound() {
      this.postRequest("/basic/clothes/refound/", this.refoundForm).then(resp => {
        if (resp) {
          this.dialogVisible4 = false;
          this.refoundForm = {};
          this.listClothes();
        }
      });
    },
    // 关闭重洗的模态框
    closeAddDialog3() {
      this.dialogVisible4 = false;
    },
    // 提醒顾客取衣
    remindCustomer(data){
      console.log(data)
        this.postRequest("/sendEmail?email="+data.cusEmail).then(resp=>{
          if(resp){

          }
        })
    }
  },
  mounted() {
    this.listClothes();
  }
};
</script>

<style scoped>
body .el-table th.gutter {
  display: table-cell !important;
}
</style>