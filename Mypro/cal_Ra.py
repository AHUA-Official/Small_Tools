

#print("我是计算器 ,请在表格内输入下列参数")
#  桩身周长u    桩端截面面积AP
#   摩擦厚度数组
#   m0   修正系数lamda   承载力基本容许值    承载力随深度修正系数    土层加权重度    埋置深度
import tkinter as tk
from tkinter import messagebox
def  get_QR(m0, lamda, bearing_capacity, depth_correction, weight_depth, embed_depth):
    #提交完这个表单后按照逻辑计算承载力容许值QR = m0* lamda *(bearing_capacity+depth_correction*weight_depth*embed_depth-3*depth_correction*weight_depth)

    QR = m0 * lamda * (bearing_capacity + depth_correction * weight_depth * embed_depth - 3 * depth_correction * weight_depth)
    return QR
def get_Ra(u, friction_thickness, ap, QR):
    # 将摩擦厚度数组中的元素转换为浮点数
    friction_thickness = [float(val) for val in friction_thickness]
    # 计算TEMP_ql
    TEMP_ql = sum(friction_thickness[i] * friction_thickness[i + 1] for i in range(0, len(friction_thickness), 2))
    print("TEMP_ql:", TEMP_ql)
    # 计算Ra
    Ra = 0.5 * u * TEMP_ql + ap * QR
    print("QR:", QR)
    print("Ra:", Ra)
    return Ra






def submit_form():
    u = float(entry_u.get())
    ap = float(entry_ap.get())
    friction_thickness = [float(x) for x in entry_friction_thickness.get().split(",")]
    m0 = float(entry_m0.get())
    lamda = float(entry_lamda.get())
    bearing_capacity = float(entry_bearing_capacity.get())
    depth_correction = float(entry_depth_correction.get())
    weight_depth = float(entry_weight_depth.get())
    embed_depth = float(entry_embed_depth.get())

    #计算结果
    QR = get_QR(m0, lamda, bearing_capacity, depth_correction, weight_depth, embed_depth)
    Ra = get_Ra(u, friction_thickness, ap, get_QR(m0, lamda, bearing_capacity, depth_correction, weight_depth, embed_depth))
    # 用户填写的数据
    message = f"桩身周长u: {u}\n桩端截面面积AP: {ap}\n摩擦厚度数组: {friction_thickness}\n" \
              f"m0: {m0}\n修正系数lamda: {lamda}\n承载力基本容许值: {bearing_capacity}\n" \
              f"承载力随深度修正系数: {depth_correction}\n土层加权重度: {weight_depth}\n" \
              f"埋置深度: {embed_depth}\n承载力容许值QR: {QR}\nRa: {Ra}"
    messagebox.showinfo("用户填写的数据和计算结果", message)

# 窗口
root = tk.Tk()
root.title("表单")

# 标签和文本框
tk.Label(root, text="桩身周长u:").grid(row=0, column=0)
entry_u = tk.Entry(root)
entry_u.grid(row=0, column=1)

tk.Label(root, text="桩端截面面积AP:").grid(row=1, column=0)
entry_ap = tk.Entry(root)
entry_ap.grid(row=1, column=1)

tk.Label(root, text="摩擦厚度数组:").grid(row=2, column=0)
entry_friction_thickness = tk.Entry(root)
entry_friction_thickness.grid(row=2, column=1)

tk.Label(root, text="m0:").grid(row=3, column=0)
entry_m0 = tk.Entry(root)
entry_m0.grid(row=3, column=1)

tk.Label(root, text="修正系数lamda:").grid(row=4, column=0)
entry_lamda = tk.Entry(root)
entry_lamda.grid(row=4, column=1)

tk.Label(root, text="承载力基本容许值:").grid(row=5, column=0)
entry_bearing_capacity = tk.Entry(root)
entry_bearing_capacity.grid(row=5, column=1)

tk.Label(root, text="承载力随深度修正系数:").grid(row=6, column=0)
entry_depth_correction = tk.Entry(root)
entry_depth_correction.grid(row=6, column=1)

tk.Label(root, text="土层加权重度:").grid(row=7, column=0)
entry_weight_depth = tk.Entry(root)
entry_weight_depth.grid(row=7, column=1)

tk.Label(root, text="埋置深度:").grid(row=8, column=0)
entry_embed_depth = tk.Entry(root)
entry_embed_depth.grid(row=8, column=1)

# 创建提交按钮
submit_button = tk.Button(root, text="提交", command=submit_form)
submit_button.grid(row=9, column=0, columnspan=2)

# 运行主事件循环
root.mainloop()
