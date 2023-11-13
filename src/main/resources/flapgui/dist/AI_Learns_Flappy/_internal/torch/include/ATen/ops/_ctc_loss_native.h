#pragma once

// @generated by torchgen/gen.py from NativeFunction.h

#include <c10/core/Scalar.h>
#include <c10/core/Storage.h>
#include <c10/core/TensorOptions.h>
#include <c10/util/Deprecated.h>
#include <c10/util/Optional.h>
#include <c10/core/QScheme.h>
#include <ATen/core/Reduction.h>
#include <ATen/core/Tensor.h>
#include <tuple>
#include <vector>


namespace at {
namespace native {
TORCH_API ::std::tuple<at::Tensor &,at::Tensor &> _ctc_loss_out(const at::Tensor & log_probs, const at::Tensor & targets, at::IntArrayRef input_lengths, at::IntArrayRef target_lengths, int64_t blank, bool zero_infinity, at::Tensor & out0, at::Tensor & out1);
TORCH_API ::std::tuple<at::Tensor,at::Tensor> ctc_loss_cpu(const at::Tensor & log_probs, const at::Tensor & targets, at::IntArrayRef input_lengths, at::IntArrayRef target_lengths, int64_t blank=0, bool zero_infinity=false);
TORCH_API ::std::tuple<at::Tensor,at::Tensor> ctc_loss_gpu(const at::Tensor & log_probs, const at::Tensor & targets, at::IntArrayRef input_lengths, at::IntArrayRef target_lengths, int64_t blank=0, bool zero_infinity=false);
TORCH_API ::std::tuple<at::Tensor,at::Tensor> ctc_loss_tensor(const at::Tensor & log_probs, const at::Tensor & targets, const at::Tensor & input_lengths, const at::Tensor & target_lengths, int64_t blank=0, bool zero_infinity=false);
} // namespace native
} // namespace at
