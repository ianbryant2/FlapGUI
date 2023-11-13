#pragma once

// @generated by torchgen/gen.py from Function.h

#include <ATen/Context.h>
#include <ATen/DeviceGuard.h>
#include <ATen/TensorUtils.h>
#include <ATen/TracerMode.h>
#include <ATen/core/Generator.h>
#include <ATen/core/Reduction.h>
#include <ATen/core/Tensor.h>
#include <c10/core/Scalar.h>
#include <c10/core/Storage.h>
#include <c10/core/TensorOptions.h>
#include <c10/util/Deprecated.h>
#include <c10/util/Optional.h>



#include <ATen/ops/_convolution_double_backward_ops.h>

namespace at {


// aten::_convolution_double_backward(Tensor? ggI, Tensor? ggW, Tensor? ggb, Tensor gO, Tensor weight, Tensor self, int[] stride, int[] padding, int[] dilation, bool transposed, int[] output_padding, int groups, bool[3] output_mask) -> (Tensor, Tensor, Tensor)
inline ::std::tuple<at::Tensor,at::Tensor,at::Tensor> _convolution_double_backward(const c10::optional<at::Tensor> & ggI, const c10::optional<at::Tensor> & ggW, const c10::optional<at::Tensor> & ggb, const at::Tensor & gO, const at::Tensor & weight, const at::Tensor & self, at::IntArrayRef stride, at::IntArrayRef padding, at::IntArrayRef dilation, bool transposed, at::IntArrayRef output_padding, int64_t groups, ::std::array<bool,3> output_mask) {
    return at::_ops::_convolution_double_backward::call(ggI, ggW, ggb, gO, weight, self, stride, padding, dilation, transposed, output_padding, groups, output_mask);
}

}
